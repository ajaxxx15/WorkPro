import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
@Injectable({
  providedIn: "root"
})
export class UserserviceService {
  constructor(private http: HttpClient) {
    this.http = http;
  }
  saveUser(user: any) {
    return this.http.post("http://13.234.155.75:8080/login/api/v1/registration", user);

  }
  loginUser(user: any): Observable<any> {
    const headers = new HttpHeaders({ "Access-Control-Allow-Orgin": "*" });
    return this.http.post("http://13.234.155.75:8080/login/api/v1/login", user, {
      headers: headers
    });
  }

}
