package id.umma.prayertimes.fatahillah.models;

import com.google.gson.annotations.SerializedName;

public class RootResponse {

    @SerializedName("results")
    private Results results;

    public Results getResults() {
        return results;
    }

}
