declare module '@apiverve/emoji' {
  export interface emojiOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface emojiResponse {
    status: string;
    error: string | null;
    data: EmojiLookupData;
    code?: number;
  }


  interface EmojiLookupData {
      count:       number;
      emojisFound: EmojisFound[];
  }
  
  interface EmojisFound {
      emoji:          string;
      description:    string;
      category:       string;
      aliases:        string[];
      tags:           string[];
      unicodeVersion: string;
      iosVersion:     string;
      codePoint:      string;
  }

  export default class emojiWrapper {
    constructor(options: emojiOptions);

    execute(callback: (error: any, data: emojiResponse | null) => void): Promise<emojiResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: emojiResponse | null) => void): Promise<emojiResponse>;
    execute(query?: Record<string, any>): Promise<emojiResponse>;
  }
}
