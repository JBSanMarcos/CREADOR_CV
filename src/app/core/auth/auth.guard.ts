import { catchError } from 'rxjs/operators/catchError';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

import { AngularFireAuth } from '@angular/fire/auth';
import { AuthService } from './auth.service';
import { NotifyService } from '../notify.service';

import { Observable } from 'rxjs';
import { map, take, tap } from 'rxjs/operators';

@Injectable()
export class AuthGuard implements CanActivate {
    constructor(
        private auth: AuthService,
        private router: Router,
        private notify: NotifyService
    ) { }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | boolean {

        return this.auth.user.pipe(
            take(1),
            map((user) => !!user),
            tap((loggedIn) => {
                if (!loggedIn) {
                    this.notify.update('You must be logged in!');
                    this.router.navigate(['/login']);
                }
            }),
            catchError((e: any) => Observable.throw(console.log(e)))
        );
    }
}
