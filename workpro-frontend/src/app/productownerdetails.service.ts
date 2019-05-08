import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductownerdetailsService {
  value: any
  data: any
  constructor(private http: HttpClient) { }

  getDtailsOfProjectOwner(value) {
    return this.http.get("http://13.234.155.75:8080/projectownerservice/api/v1/projectOwner/" + value);
  }

  setProjectDetails(value) {
    return this.http.post("http://13.234.155.75:8080/projectdetailservice/api/v1/projects/project", value, { responseType: "text" });

  }

  getProjectDetails(value) {
    return this.http.get("http://13.234.155.75:8080/projectdetailservice/api/v1/projectOwner/" + value + "/project");
  }
  getProjectDetailsById(value, value2) {
    return this.http.get("http://13.234.155.75:8080/projectdetailservice/api/v1/projectOwner/" + value + "/projects/" + value2);
  }

  awardProject(value, value1, value2,value3) {
    return this.http.put("http://13.234.155.75:8080/projectdetailservice/api/v1/projectOwner/" + value + "/projects/" + value1 + "/bid/accept/" + value2,value3, { responseType: 'text' });
  }

  getResults(skillName) {
    return this.http.get("http://13.234.155.75:8080/projectdetailservice/api/v1/skill/" + skillName + "/projects");

  }
  updateDetailsOfProjectOwner(data) {
    return this.http.put("http://13.234.155.75:8080/projectownerservice/api/v1/projectOwner/" + data.email, data);
  }

  postDetailsOfProjectOwner(data) {
    return this.http.post("http://13.234.155.75:8080/projectownerservice/api/v1/projectOwner/projectOwnerId", data);
  }


}
