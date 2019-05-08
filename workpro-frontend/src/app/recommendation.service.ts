import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  constructor(private http: HttpClient) { }

  getAllFreelancerRecommendation(value: any) {
    return this.http.get("http://13.234.155.75:8080/recommendations/api/v1/recommendations/allfreelancer/Skill/" + value);
  }

  getAllProjectRecommendation(value: any) {
    console.log(value)
    return this.http.get("http://13.234.155.75:8080/recommendations/api/v1/recommendations/allProjects/Skill/" + value);
  }

}
