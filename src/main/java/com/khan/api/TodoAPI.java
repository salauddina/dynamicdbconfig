package com.khan.api;

import com.khan.dao.TodoDAO;
import com.khan.entity.Todo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

@Path("todos")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoAPI {

    @Inject
    TodoDAO todoDAO;

    @GET
    public Response getAll() {
        return Response.ok(todoDAO.findAll(Todo.class)).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
       Todo todo = (Todo) todoDAO.find(id, Todo.class);
        return Response.ok(todo).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Todo todo) throws Exception {

        Todo updateTodo = (Todo) todoDAO.find(id, Todo.class);

        updateTodo.setTask(todo.getTask());
        updateTodo.setDescription(todo.getDescription());
        todoDAO.update(updateTodo);

        return Response.ok().build();
    }

    @POST
    public Response create(Todo todo) {
        todoDAO.save(todo);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Todo getTodo = (Todo) todoDAO.find(id, Todo.class);
        todoDAO.delete(getTodo);
        return Response.ok().build();
    }
}
