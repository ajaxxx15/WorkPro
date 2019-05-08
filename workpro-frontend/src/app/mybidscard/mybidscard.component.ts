import { Component, OnInit, Input } from '@angular/core';
import { projection } from '@angular/core/src/render3';

@Component({
  selector: 'app-mybidscard',
  templateUrl: './mybidscard.component.html',
  styleUrls: ['./mybidscard.component.scss']
})
export class MybidscardComponent implements OnInit {

  constructor() { }
  @Input() project;
  ngOnInit() {
  }

}
