import { radarCommandBaseURL, radarQueryBaseURL } from "./urls";
import {
  getAPICall,
  postAPICall,
  putAPICall,
  deleteAPICall,
} from "./axiosMethodCalls";

export const getAllRadars = async () => {
  try {
    const response = await getAPICall(radarQueryBaseURL);
    return response.data;
  } catch (error) {
    return error.response;
  }
};
