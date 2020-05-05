import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SubscriptionService} from "../../entities/subscription.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  quoteSubscriptionForm: FormGroup;
  validMessage: string = "";

  constructor(private subscriptionService: SubscriptionService) {
  }

  ngOnInit(): void {
    this.quoteSubscriptionForm = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.email)
    });
  }

  subscribe() {
    if (this.quoteSubscriptionForm.valid) {
      this.subscriptionService.save(this.quoteSubscriptionForm.value).subscribe(
        data => {
          this.validMessage = "Subscribed !";
          this.quoteSubscriptionForm.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      this.validMessage = "Please fill out the form before submitting";
    }
  }

}
