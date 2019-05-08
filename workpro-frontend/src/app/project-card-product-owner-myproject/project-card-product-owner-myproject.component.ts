import { Component, OnInit, Input } from "@angular/core";
import { MyprojectsComponent } from "../myprojects/myprojects.component";

@Component({
  selector: "app-project-card-product-owner-myproject",
  templateUrl: "./project-card-product-owner-myproject.component.html",
  styleUrls: ["./project-card-product-owner-myproject.component.scss"]
})
export class ProjectCardProductOwnerMyprojectComponent implements OnInit {
  constructor() { }
  @Input() project;
  ngOnInit() { }
}


