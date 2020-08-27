export interface Data {
  mobileNumber: number;
  firstName: string;
  lastName: string;
  birthDate?: string;
  genderId?: string;
  email: string;
}

export interface AjaxResponse<T> {
  status: boolean;
  message: string;
  data: T;
}
