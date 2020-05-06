import {Component, OnInit} from '@angular/core';

import {KeycloakService} from 'keycloak-angular';
import {Router} from '@angular/router';
import {KeycloakProfile} from "keycloak-js";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  userDetails: KeycloakProfile;

  constructor(private router: Router,
              private keycloakService: KeycloakService) {
  }

  async doLogout() {
    await this.keycloakService.logout();
    await this.router.navigate(['/']);
  }

  doLogin(): void {
    this.keycloakService.login();
  }

  async ngOnInit() {
    if (await this.keycloakService.isLoggedIn()) {
      this.userDetails = await this.keycloakService.loadUserProfile();
      console.log(this.userDetails);
    }
  }
}
