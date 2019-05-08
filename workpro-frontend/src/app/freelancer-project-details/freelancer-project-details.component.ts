import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-freelancer-project-details',
  templateUrl: './freelancer-project-details.component.html',
  styleUrls: ['./freelancer-project-details.component.scss']
})
export class FreelancerProjectDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    console.log(this.projects)
  }
  projects = [];
  projects1 = [
    {
      projectOwnerName: "Roopali",
      projectOwnerEmailId: "roopali@gmail.com",
      projectDetails: [
        {
          projectId: 1,
          projectName: "ProjectName",
          projectstatus: "Open",
          projectAwarded: false,
          projectCompletionDate: "some Date",
          projectPreference: "onsite",
          projcetLocation: "Mumbai",
          projectDescription: "this is description",
          bidSpecProvidedByProjectOwner: {
            maximumBudget: 2093,
            minimumBudget: 1380,
            bidLastDate: "this is Date"
          },
          skills: [
            {
              skillName: "Angular"
            },
            {
              skillName: "Java"
            }
          ]
        },
        {
          projectId: 2,
          projectName: "ProjectName",
          projectstatus: "Open",
          projectAwarded: false,
          projectCompletionDate: "some Date",
          projectPreference: "",
          projcetLocation: "Mumbai",
          projectDescription: "this is description",
          bidSpecProvidedByProjectOwner: {
            maximumBudget: 2093,
            minimumBudget: 1380,
            bidLastDate: "this is Date"
          },
          skills: [
            {
              skillName: "Angular"
            },
            {
              skillName: "Java"
            }
          ]

        },
        {
          projectId: 3,
          projectName: "ProjectName",
          projectstatus: "Open",
          projectAwarded: false,
          projectCompletionDate: "some Date",
          projectPreference: "",
          projcetLocation: "Mumbai",
          projectDescription: "this is description",
          bidSpecProvidedByProjectOwner: {
            maximumBudget: 2093,
            minimumBudget: 1380,
            bidLastDate: "this is Date"
          },
          skills: [
            {
              skillName: "Angular"
            },
            {
              skillName: "Java"
            }
          ]
        }
      ]
    }
  ];
}
