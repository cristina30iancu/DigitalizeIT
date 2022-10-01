import { ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { iNewJoiner } from '../models/inewjoiner';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newjoiner',
  templateUrl: './newjoiner.component.html',
  styleUrls: ['./newjoiner.component.css']
})
export class NewjoinerComponent implements OnInit {
  @Input()
  index: number;

  @Input()
  newJoiner: iNewJoiner;

  @Input()
  username: string | undefined;

  @Output() listUpdated = new EventEmitter<number>();

  newJoinersEndpoint: string = 'http://localhost:8085/newJoiner'; // newJoiner: move in service

  constructor(private router: Router, private cdRef: ChangeDetectorRef) {
    this.index = 0;
    this.newJoiner
 = {} as iNewJoiner
;
    this.username = '';
  }

  ngOnInit(): void {
  }



  ngAfterViewInit() {
    console.log("! changement de la date du composant !");
    this.cdRef.detectChanges();
  }


}
