import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {Subscription} from "rxjs";
import {UserService} from "../user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users?: User[] = [];
  private usersSubscription?: Subscription;

  constructor(
    private userService: UserService,
    private router: Router) {}


  ngOnInit() {
    this.userService.getAllUsers().subscribe(
      response => {
        this.users = response;
      })
  }

  ngOnDestroy(): void {
    if (this.usersSubscription) {
      this.usersSubscription.unsubscribe();
    }
  }

}
