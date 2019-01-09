import { Component, OnInit} from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit{
  title = 'Desafio Cielo';
  lancamentos:any = [];

  constructor(private http: HttpClient) {}

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  ngOnInit() {
    this.getLancamentos();
  }

  getLancamentos() {
    this.http.get("http://localhost:8080/api/lancamentos")
      .pipe(map(this.extractData))
      .subscribe((data: {}) => {
        this.lancamentos = data;
        console.log(data, this.lancamentos);
      });
  }
}
