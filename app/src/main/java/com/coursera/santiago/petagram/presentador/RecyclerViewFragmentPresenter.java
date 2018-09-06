package com.coursera.santiago.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.coursera.santiago.petagram.db.ConstructorMascotas;
import com.coursera.santiago.petagram.fragment.IRecyclerViewFragmentView;
import com.coursera.santiago.petagram.pojo.Mascota;
import com.coursera.santiago.petagram.restApi.EndpointApi;
import com.coursera.santiago.petagram.restApi.adapter.RestApiAdapter;
import com.coursera.santiago.petagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView mIRecyclerViewFragmentView;
    private Context mContext;
    private ConstructorMascotas mConstructorMascotas;
    private ArrayList<Mascota> mMascotas;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.mIRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.mContext = context;
//        obtenerMascotasBaseDatos();
        obtenerMascotasMediosRecientes();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        mConstructorMascotas = new ConstructorMascotas(mContext);
        mMascotas = mConstructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMascotasMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointApi endpointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endpointApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mMascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
                mIRecyclerViewFragmentView.cargarOtroCampos(mMascotas);
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(mContext, "Ha fallado la llamada", Toast.LENGTH_LONG).show();
                Log.e("Retrofit", t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRV() {
        mIRecyclerViewFragmentView.inicializarAdaptador(mIRecyclerViewFragmentView.crearAdaptador(mMascotas));
//        mIRecyclerViewFragmentView.generarLinearLayoutVertical();
        mIRecyclerViewFragmentView.generarGridLayout();
    }

    public ArrayList<Mascota> getMascotas() {
        return mMascotas;
    }
}
