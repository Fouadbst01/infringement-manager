import axios from "axios";

export const getAPICall = (url) => {
  return axios.get(url);
};

export const postAPICall = (url, data) => {
  return axios.post(url, data);
};

export const putAPICall = (url, data) => {
  return axios.put(url, data);
};

export const deleteAPICall = (url) => {
  return axios.delete(url);
};
