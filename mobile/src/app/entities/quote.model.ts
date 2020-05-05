export interface IQuote {
  id?: number;
  author?: string;
  content?: string;
  readCount?: number;
  likeCount?: number;
  dislikeCount?: number;
}

export class Quote implements IQuote {
  constructor(
    public id?: number,
    public author?: string,
    public content?: string,
    public readCount?: number,
    public likeCount?: number,
    public dislikeCount?: number,
  ) {
  }
}
