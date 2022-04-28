/**
 * 
 */
package response;

/**
 * @author Shubhashish PC
 *
 */
public class MessageResponse {
	
	private String message;

	public MessageResponse(String message) {
		System.out.println(message);
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
