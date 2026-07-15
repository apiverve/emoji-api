declare module '@apiverve/emoji' {
  export interface emojiOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface emojiResponse {
    status: string;
    error: string | null;
    data: EmojiLookupData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface EmojiLookupData {
      count:       number | null;
      emojisFound: EmojisFound[];
  }
  
  interface EmojisFound {
      emoji:          null | string;
      description:    null | string;
      category:       null | string;
      aliases:        (null | string)[];
      tags:           (null | string)[];
      unicodeVersion: null | string;
      iosVersion:     null | string;
      codePoint:      null | string;
  }

  export default class emojiWrapper {
    constructor(options: emojiOptions);

    execute(callback: (error: any, data: emojiResponse | null) => void): Promise<emojiResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: emojiResponse | null) => void): Promise<emojiResponse>;
    execute(query?: Record<string, any>): Promise<emojiResponse>;
  }
}
