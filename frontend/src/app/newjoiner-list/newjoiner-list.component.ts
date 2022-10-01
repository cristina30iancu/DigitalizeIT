import { RequestService } from './../_services/request.service';
import { Component, OnInit } from '@angular/core';
import { iNewJoiner } from '../models/inewjoiner';

@Component({
  selector: 'app-newjoiner-list',
  templateUrl: './newjoiner-list.component.html',
  styleUrls: ['./newjoiner-list.component.css']
})
export class NewjoinerListComponent implements OnInit {

  // request all todos from jsonplaceholder and save them into an array
  newjoiners: iNewJoiner[];
  // https://jsonplaceholder.typicode.com/todos
  todosEndpoint: string = 'http://localhost:8085/newjoiner';
  emptyNewJoiner: iNewJoiner = {} as iNewJoiner;
  username: string;

  // dependency injection
  constructor(
    private requestService: RequestService
  ) {
    this.newjoiners = [];
    console.log('construct component');
    this.emptyNewJoiner.last_name = 'Empty Todo';
    this.emptyNewJoiner.id = -1;
    this.username = 'vasile';
  }

  async ngOnInit(): Promise<void> {
    console.log('init component');
    // this.requestTodos();
    await this.requestService.setupApi();
    this.newjoiners = await this.requestService.sendRequest<iNewJoiner[]>(this.newjoiners,"newjoiner"); // remove await
  }

  requestedUpdateListAfterDelete(index: number): void {
    console.log('requested list update after delete', index);
    this.newjoiners.splice(index, 1);
  }
}