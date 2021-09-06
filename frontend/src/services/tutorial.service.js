import http from "../http-common";

class TutorialDataService {
  getPosts() {
    return http.get("/posts");
  }

  getAlbums() {
    return http.get("/albums");
  }

  getTodos() {
    return http.get("/todos");
  }

}

export default new TutorialDataService();