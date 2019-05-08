import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class FreelancerDetailsService {
  value: any;
  data: any;
  constructor(private http: HttpClient) { }
  getDetailsOfFreelancers(value) {
    return this.http.get("http://13.234.155.75:8080/freelancerservice/api/v1/freelancer/" + value);
  }


  updateDetailsofFreelancers(email, data) {
    return this.http.put("http://13.234.155.75:8080/freelancerservice/api/v1/freelancerprofile/" + email, data);
  }



  getBidsofFreelancer(value) {
    return this.http.get("http://13.234.155.75:8080/freelancerservice/api/v1/bid/allbids/" + value);
  }
  postFreelancerDetails(value) {
    return this.http.post("http://13.234.155.75:8080/freelancerservice/api/v1/freelancerprofile/postDetails", value, { responseType: 'text' });

  }

  getAwardedBids(value) {
    return this.http.get("http://13.234.155.75:8080/freelancerservice/api/v1/bid/awardedBids/" + value)
  }


  getSearchResults(skill) {
    return this.http.get("http://13.234.155.75:8080/freelancerservice/api/v1/skill/" + skill);
  }

  postBids(body) {
    return this.http.post("http://13.234.155.75:8080/freelancerservice/api/v1/bid/bidDetails", body);
  }


  inviteFreelancer(id,email,body) {
    return this.http.post("http://13.234.155.75:8080/freelancerservice/api/v1/send/"+id+"/"+email,body);
  }

}
