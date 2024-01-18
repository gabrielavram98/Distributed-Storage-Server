package proiectdiz.Storage.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.RequestHandler;

@RestController
public class InputController {

    @PostMapping("/api/server1/store")
    public HttpStatus Input(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"1");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server2/store")
    public HttpStatus Input2(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"2");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server3/store")
    public HttpStatus Input3(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"3");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server4/store")
    public HttpStatus Input4(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"4");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server5/store")
    public HttpStatus Input5(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"5");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server6/store")
    public HttpStatus Input6(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"6");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server7/store")
    public HttpStatus Input7(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"7");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server8/store")
    public HttpStatus Input8(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);

            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody,"8");
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server1/get")
    public HttpStatus Output1(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody,"1");

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @PostMapping("/api/server2/get")
    public HttpStatus Output2(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody,"2");

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @PostMapping("/api/server3/get")
    public HttpStatus Output3(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody,"3");

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @PostMapping("/api/server4/get")
    public HttpStatus Output4(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody,"4");

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @PostMapping("/api/server5/get")
    public HttpStatus Output5(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody,"5");

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @PostMapping("/api/server6/get")
    public HttpStatus Output6(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody,"6");

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @PostMapping("/api/server7/get")
    public HttpStatus Output7(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody,"7");

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }




}
