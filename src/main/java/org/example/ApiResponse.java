import com.google.gson.annotations.SerializedName;

// Usamos um 'record' para representar de forma simples os dados da resposta JSON.
// @SerializedName é usado para mapear o nome do campo no JSON ("conversion_rate")
// para o nosso nome em Java ("conversionRate").
public record ApiResponse(
        String result,
        @SerializedName("conversion_rate") double conversionRate
) {}