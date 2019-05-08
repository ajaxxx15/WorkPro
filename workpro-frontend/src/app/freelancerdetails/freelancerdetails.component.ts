import { Component, OnInit } from '@angular/core';
import { FreelancerDetailsService } from '../freelancer-details.service'
import { from } from 'rxjs';
import { Router } from "@angular/router";
@Component({
  selector: 'app-freelancerdetails',
  templateUrl: './freelancerdetails.component.html',
  styleUrls: ['./freelancerdetails.component.scss']
})
export class FreelancerdetailsComponent implements OnInit {

  constructor(private fservice: FreelancerDetailsService, private router: Router) { }
  skills = [];
  domains = [];
  samplelinks = [];
  ngOnInit() {


  }
  save(data) {
    data.skills = this.skills
    data.domain = this.domains
    data.link = this.samplelinks
    this.router.navigateByUrl("userdashboard")
  }



  addSkill(skill) {
    let skillDetails = {
      yearsOfExp: skill.SkillExp,
      level: skill.level,
      skillName: skill.SkillName
    }
    this.skills.push(skillDetails)
  }

  addDomain(domain) {
    let domainDetails = {
      domainName: domain.DomainName,
      yearsOfExp: domain.DomainExperience
    }
    this.domains.push(domainDetails)
  }

  addLink(samplelink) {
    let linkDetails = {
      link: samplelink.Link
    }
    this.samplelinks.push(linkDetails)
  }
  deleteSkill(skill) {
    this.skills = this.skills.filter(e => e.skillName !== skill.skillName)
  }
  deleteDomain(domain) {
    this.domains = this.domains.filter(e => e.domainName !== domain.domainName)
  }
  freelancers = []
  freelancer1 =
    {
      id: 1,
      freelancerName: "Prateema",
      freelancerEmail: "pratima447@gmail.com",
      freelancerAddress: "ythtkyuyuku143432345345",
      yearsOfExpertise: 2,
      skills: "java/Angular",

    };
  freelancer2 =
    {
      id: 1,
      freelancerName: "Prateema",
      freelancerEmail: "pratima447@gmail.com",
      freelancerAddress: "ythtkyuyuku143432345345",
      yearsOfExpertise: 2,
      skills: "java/Angular",

    };
  freelancer3 =
    {
      id: 1,
      freelancerName: "Prateema",
      freelancerEmail: "pratima447@gmail.com",
      freelancerAddress: "ythtkyuyuku143432345345",
      yearsOfExpertise: 2,
      skills: "java/Angular",

    };
  freelancer4 =
    {
      id: 1,
      freelancerName: "Prateema",
      freelancerEmail: "pratima447@gmail.com",
      freelancerAddress: "ythtkyuyuku143432345345",
      yearsOfExpertise: 2,
      skills: "java/Angular",

    }
}
