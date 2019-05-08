import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})

export class FreelancerserviceService {

  constructor(private http: HttpClient) { }
  getProjectsFreelancer(skills) {
    return this.http.get("http://localhost:3000/projects/" + skills)
    // TODO: take the data and add that in the comment section in this call
    // {
    //   projectName:
    //   projectDescription:
    //   button1:(view details)
    //   button2:(Bid)
    // }
  }
  getFreelancerDetails(Id) {
    return this.http.get("http://localhost:3000/freelancerprofile/" + Id)
    // {
    //   freelancerImage:
    //   freelancerName:
    //   freelancerSkills:
    // }
  }
  putFreelancerProfile(profileData) {
    return this.http.put("http://localhost:3000/freelancerprofile/" + profileData.id, profileData);
  }

  deleteFreelancerProfile(Id) {
    return this.http.delete("http://localhost:3000/freelancerprofile/" + Id);

  }
  getfFreelancerBids() {
    return this.http.get("http://localhost:3000/bids/allBids")
  }

  addFreelancerBid(bidData) {
    return this.http.post("http://localhost:3000/bid", bidData);
  }
 

}
