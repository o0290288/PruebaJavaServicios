import com.google.gson.Gson;
import mx.com.ots.domain.WS.ResponseDTO;
import mx.com.ots.domain.WS.ServiciosM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterWsTest {

    @Test
    public void character(){
        ServiciosM serviciosM = new ServiciosM();
        String result = serviciosM.charter();
        Gson gson = new Gson();
        ResponseDTO responseDTO = gson.fromJson(result, ResponseDTO.class);
        Assertions.assertTrue(result.contains("\"status\":\"Ok\""));
        Assertions.assertEquals(responseDTO.getCode(),200);
        Assertions.assertEquals(responseDTO.getStatus(),"Ok");

    }

    @Test
    public void characterId(){
        ServiciosM serviciosM = new ServiciosM();
        String result = serviciosM.charterId(1017851l);
        Gson gson = new Gson();
        ResponseDTO responseDTO = gson.fromJson(result, ResponseDTO.class);
        Assertions.assertTrue(result.contains("\"status\":\"Ok\""));
        Assertions.assertEquals(responseDTO.getCode(),200);
        Assertions.assertEquals(responseDTO.getStatus(),"Ok");

    }
}
