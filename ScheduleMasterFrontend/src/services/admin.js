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
    console.log(`Error in Register : `, ex);
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
    console.log(`Error in Register Course: `, ex);
  }
}

export async function registerModule(name, hours) {
  debugger;
  try {
    // post body
    const body = { name, hours };

    // send the post request
    const response = await axios.post(
      `${config.serverUrl}/module/addmodule`,
      body
    );

    // return the json body from response object
    return response;
  } catch (ex) {
    console.log(`Error in Register Module: `, ex);
  }
}
export async function login(userName, password) {
  debugger;
  const body = { userName, password };
  try {
    const response = await axios.post(`${config.serverUrl}/user/login`, body);
    return response;
  } catch (ex) {
    console.log(`Error in Login: `, ex);
  }

  return null;
}
export async function getFacultyDetails() {
  debugger;
  try {
    const response = await axios.get(
      `${config.serverUrl}/faculty/allFaculties`
    );
    console.log(response.data);
    return response;
  } catch (ex) {
    console.log(`Error fetching Faculty Details: `, ex);
  }

  return null;
}
export async function getCourses() {
  debugger;
  try {
    const response = await axios.get(`${config.serverUrl}/course/`);
    console.log(response);
    return response;
  } catch (ex) {
    console.log(`Error fetching courses: `, ex);
    throw ex;
  }
}
export async function getModulesByCourse(courseId) {
  debugger;
  try {
    const response = await axios.get(
      `${config.serverUrl}/course/module/${courseId}`
    );
    console.log(response);
    return response;
  } catch (ex) {
    console.log(`Error fetching modules: `, ex);
    return ex;
  }
}

export async function getFaculty() {
  debugger;
  try {
    const response = await axios.get(
      `${config.serverUrl}/faculty/allFaculties`
    );
    console.log(response);
    return response;
  } catch (ex) {
    console.log(`Error fetching faculties: `, ex);
    return ex;
  }
}
export async function scheduleFaculty(
  courseId,
  moduleId,
  facultyId,
  startDate,
  endDate,
  startTime,
  endTime
) {
  debugger;
  try {
    // post body
    const body = {
      courseId,
      moduleId,
      facultyId,
      startDate,
      endDate,
      startTime,
      endTime,
    };

    // send the post request
    const response = await axios.post(
      `${config.serverUrl}/schedule/create`,
      body
    );
    console.log(response);
    // return the json body from response object
    return response;
  } catch (ex) {
    console.log(`Error in Schedule Faculty : `, ex);
  }
}
