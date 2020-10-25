import { Moment } from 'moment';
import { IUser } from 'app/shared/model/user.model';

export interface IResultTest {
  id?: number;
  finishedAt?: string;
  demonstrativeType?: number;
  stuckType?: number;
  pedanticType?: number;
  excitableType?: number;
  hyperthymicType?: number;
  dysthymicType?: number;
  anxiouslyFearfulType?: number;
  emotionallyExaltedType?: number;
  emotiveType?: number;
  cyclothymicType?: number;
  user?: IUser;
}

export const defaultValue: Readonly<IResultTest> = {};
