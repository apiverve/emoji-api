using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.EmojiLookup
{
    /// <summary>
    /// Query options for the Emoji Lookup API
    /// </summary>
    public class EmojiLookupQueryOptions
    {
        /// <summary>
        /// The emoji for which you want to get the text representation (e.g., 🥳)
        /// Example: 🥳
        /// </summary>
        [JsonProperty("emoji")]
        public string Emoji { get; set; }
    }
}
