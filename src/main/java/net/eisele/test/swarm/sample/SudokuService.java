package net.eisele.test.swarm.sample;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.ncidence.sudoku.sudokusolver.SudokuSolverDriver;


/**
 * REST Web Service
 *
 * @author myfear
 */
@Path("sudoku")
public class SudokuService {
	
	public static String INPUT= "input";

    @Context
    UriInfo context;

    /**
     * Creates a new instance of CustomerService
     */
    public SudokuService() {
    }

    /**
     * Simple example to output request URI and hostname
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
    	String input = null;
    	MultivaluedMap<String, String> queryParameters = context.getQueryParameters();
    	if(queryParameters != null && queryParameters.containsKey(INPUT) && queryParameters.get(INPUT) != null && !queryParameters.get(INPUT).isEmpty()){
    		input = queryParameters.get(INPUT).get(0);
    	}
    	
    	SudokuSolverDriver driver = new SudokuSolverDriver();
    	return driver.solveCsv(input);
    }

}
