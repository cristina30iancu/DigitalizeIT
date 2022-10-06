import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NjserviceService } from '../_services/njservice.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  positions : any;
  errors!: Boolean;
  message!: string;
  succes!: Boolean;
  constructor(private njService: NjserviceService) { this.positions = [];}

  ngOnInit() {
   this.njService.getPositions().subscribe(res => { this.positions = res;})
  }
  
  submit(addForm: NgForm){
    console.log(addForm.value)
    addForm.value.done = 'false';
    this.njService.addNewJoiner(addForm.value).subscribe(
      (response: any) => {
        console.log(response);
        if(response.id && response.lastName)
          this.succes = true;
      },
      (error) => {
        this.errors = true;
        if(error == 400){
          this.message = 'Please fill in all details!';
        }
      }
    );
  }
}