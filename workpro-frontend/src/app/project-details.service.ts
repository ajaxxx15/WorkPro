import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectDetailsService {

  constructor(private http:HttpClient) { }
  private baseUrl:String='http://localhost:3000/posts';
  public user:any={};
  saveToJson(user)
  {
    this.http.post('http://localhost:3000/posts',user).subscribe(data=>
      console.log(data))
  }

addProject(Id){
  this.http.post("http://localhost3000/projects/project" + Id , {})
}

getAllProjects(skills){
  this.http.get("http://localhost:3000/projectowner/{projectownerid}/project" + skills)
}

acceptBid(bidData){
  this.http.put("http://localhost:3000/projectowner/{projectownerid}/projects/{projectid}/bid/accept" + bidData.Id , bidData)

}
getallBids(bidData){
  this.http.get("http://localhost:3000/projectowner/{projectid}/projects/{projectid}/bids" + bidData)
}
}