import { IQuestion } from 'app/shared/model/question.model';
import { IResultTest } from 'app/shared/model/result-test.model';

export interface IAnswer {
  id?: number;
  answer?: boolean;
  question?: IQuestion;
  resultTest?: IResultTest;
}

export const defaultValue: Readonly<IAnswer> = {
  answer: false,
};
