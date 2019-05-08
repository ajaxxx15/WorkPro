import { Component, OnInit, Input } from "@angular/core";
import { ProductownerdetailsService } from '../productownerdetails.service';

@Component({
  selector: "app-myprojects",
  templateUrl: "./myprojects.component.html",
  styleUrls: ["./myprojects.component.scss"]
})
export class MyprojectsComponent implements OnInit {
  projects = [];
  projects1: any = [];
  email: String = localStorage.getItem("email");
  constructor(private productownerdetailsService: ProductownerdetailsService) { }

  @Input()
  ngOnInit() {
    this.productownerdetailsService.getProjectDetails(this.email).subscribe(data => {
      this.projects1 = data
      this.projects = this.projects1.projectDetailsList;
    });

  }

  filterOpenProjects() {
    this.projects = this.projects1["projectDetailsList"].filter(e => {
      if (e.projectStatus === "open") {
        return e;
      }
    });
  }
  filterCloseProjects() {
    this.projects = this.projects1["projectDetailsList"].filter(e => {
      if (e.projectStatus === "closed") {
        return e;
      }
    });
  }
}
