import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Imc } from "../model/imc.model";

@Injectable({
  providedIn: "root",
})
export class ImcService {
  public static readonly ENDPOINT = environment.api + "/imc";

  constructor(private httpClient: HttpClient) {}

  save(idUsuario: number, imc: Imc): Observable<Imc> {
    return this.httpClient.post<Imc>(
      ImcService.ENDPOINT + `/${idUsuario}`,
      imc
    );
  }

  getAll(idUsuario: number): Observable<Imc[]> {
    return this.httpClient.get<Imc[]>(ImcService.ENDPOINT + `/${idUsuario}`);
  }
}
