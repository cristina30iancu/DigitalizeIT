import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NjserviceService } from '../_services/njservice.service';
import { IPosition} from '../models/iposition';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  positions : any;
  constructor(private njService: NjserviceService) { this.positions = [];}

  ngOnInit() {
   this.njService.getPositions().subscribe(res => { this.positions = res;})
  }
  
  submit(addForm: NgForm){

  }
}
