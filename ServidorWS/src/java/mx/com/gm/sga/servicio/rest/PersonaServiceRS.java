package mx.com.gm.sga.servicio.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

// Se agregan las anotacion de JaxRs
@Path("/personas")
@Stateless // Se indica que esta clase es un EJB 
public class PersonaServiceRS {

    @EJB // tambien se puede utilizar @inject 
    private PersonaService personaService;
    //Posteriormente se empiezan agregar los metodos correspondientes
    @GET //Metoddo Http Indicando datos en JSON o XML.
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }
    //Metodo encontrar usuario por ID
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}") //hace referencia a /personas/{id}    
    public Persona encontrarPersonaPorId(@PathParam("id") int id) { 
        return personaService.encontrarPersonaPorId(new Persona(id));
    }
    
    @POST
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarPersona(Persona persona) { // Se agrega una respuesta para indicar si se ejecuta de manera correcta la insercion
        try {
            personaService.registrarPersona(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) { //Dado caso que se genere un error
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT //Metodo para modificar una usuario.
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        try {
            Persona persona = personaService.encontrarPersonaPorId(new Persona(id));
            if (persona != null) {
                personaService.modificarPersona(personaModificada);
                return Response.ok().entity(personaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build(); //Caso en que no se encuentre un objeto
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id) {
        try {
            personaService.eliminarPersona(new Persona(id));
            return Response.ok().build(); //Se construte la respuesta como anteriormente mencionado. 
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
}