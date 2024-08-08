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
export async function registerCourse(
  courseName,
  fee,
  description,
  startDate,
  endDate,
  capacity
) {
  debugger;
  try {
    // post body
    const body = { courseName, fee, description, startDate, endDate, capacity };

    // send the post request
    const response = await axios.post(
      `${config.serverUrl}/course/register`,
      body
    );

    // return the json body from response object
    return response;
  } catch (ex) {
    console.log(`exception: `, ex);
  }
}
export async function login(userName, password) {
  debugger;
  const body = { userName, password };
  try {
    const response = await axios.post(`${config.serverUrl}/user/login`, body);
    return response;
  } catch (ex) {
    console.log(`exception: `, ex);
  }

  return null;
}
