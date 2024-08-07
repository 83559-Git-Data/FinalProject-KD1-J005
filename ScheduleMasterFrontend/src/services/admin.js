import axios from "axios";
import { config } from "./config";

export async function register(firstName, lastName, userName, password, role) {
  debugger;
  try {
    // post body
    const body = { firstName, lastName, userName, password, role };

    // send the post request
    const response = await axios.post(
      `${config.serverUrl}/user/register`,
      body
    );

    // return the json body from response object
    return response;
  } catch (ex) {
    console.log(`exception: `, ex);
  }
}
