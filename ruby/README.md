# Emoji Lookup API - Ruby Gem

Emoji Lookup searches emoji characters, tags, or categories to return descriptive names and classifications. Query by raw symbol, keyword tag, or category to inspect matching emoji glyphs, text descriptions, and categories.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_emoji'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_emoji
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_emoji'

# Initialize the client
client = APIVerve::Emoji::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ emoji: "🥳" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ emoji: "🥳" })
  puts response["data"]
rescue APIVerve::Emoji::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Emoji::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Emoji::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 1,
    "emojisFound": [
      {
        "emoji": "🥳",
        "description": "partying face",
        "category": "Smileys & Emotion",
        "aliases": [
          "partying_face"
        ],
        "tags": [
          "celebration",
          "birthday"
        ],
        "unicode_version": "11.0",
        "ios_version": "12.1",
        "codePoint": "1f973"
      }
    ]
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/emoji?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/emoji?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/emoji?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
