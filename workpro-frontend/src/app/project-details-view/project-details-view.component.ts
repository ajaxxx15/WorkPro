import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BidviewComponent } from '../bidview/bidview.component';
import { ActivatedRoute } from '@angular/router';
import { ProductownerdetailsService } from '../productownerdetails.service';

@Component({
  selector: 'app-project-details-view',
  templateUrl: './project-details-view.component.html',
  styleUrls: ['./project-details-view.component.scss']
})
export class ProjectDetailsViewComponent implements OnInit {
  isLoggedIn = false;
  id: String;
  email: String;
  project: any = [];
  skills: any;
  pname: String

  constructor(public dialog: MatDialog, private route: ActivatedRoute, private productownerdetailsService: ProductownerdetailsService) { }

  ngOnInit() {
    if (localStorage.getItem('token') !== null) {
      this.isLoggedIn = true;
    }
    this.route.params.subscribe(data => {
      this.id = data.id;
      this.email = data.email;

    });
    this.productownerdetailsService.getProjectDetailsById(this.email, this.id).subscribe(data => {
      this.project = data;
      this.pname = this.project.projectName;
      this.skills = this.project['skillsSetList']
    })
  }

  openDialog() {
    const dialogRef = this.dialog.open(BidviewComponent, {
      data: { pid: this.id, pname: this.pname, poemail: this.email, freelanceremail: localStorage.getItem('email') }

    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
