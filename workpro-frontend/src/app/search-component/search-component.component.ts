import { Component, OnInit } from '@angular/core';
import { ProductownerdetailsService } from '../productownerdetails.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-component',
  templateUrl: './search-component.component.html',
  styleUrls: ['./search-component.component.scss']
})
export class SearchComponentComponent implements OnInit {

  id: String;
  constructor(private projectService: ProductownerdetailsService, private route: ActivatedRoute) { }
  projects:any=[];
  message=false

  ngOnInit() {
    this.route.params.subscribe(data => {
      this.id = data.id;
    })
    this.projectService.getResults(this.id).subscribe((data: any) => {
      this.projects = data;
      console.log(this.projects)
      if(this.projects===null){
        this.message=true
      }
    });
  }

}
