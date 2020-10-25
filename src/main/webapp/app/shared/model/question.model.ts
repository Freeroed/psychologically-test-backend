import { IQuestionType } from 'app/shared/model/question-type.model';

export interface IQuestion {
  id?: number;
  question?: string;
  isAdd?: boolean;
  questionType?: IQuestionType;
}

export const defaultValue: Readonly<IQuestion> = {
  isAdd: false,
};
