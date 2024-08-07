import axios from "axios";
import { config } from "./config";

export async function register(firstName, lastName, username, password, role) {
  debugger;
  try {
    // post body
    const body = { firstName, lastName, username, password, role };

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
export async function login(username, password) {
  debugger;
  const body = { username, password };
  try {
    const response = await axios.post(`${config.serverUrl}/user/login`, body);
    return response;
  } catch (ex) {
    console.log(`exception: `, ex);
  }

  return null;
}
