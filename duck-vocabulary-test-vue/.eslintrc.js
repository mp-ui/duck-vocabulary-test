module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: [
    'plugin:vue/essential',
    '@vue/standard'
  ],
  parserOptions: {
    parser: 'babel-eslint'
  },
  rules: {
    "editor.tabSize": 2,
    "editor.formatOnSave": true,
    "prettier.disableLanguages": ["vue", "css", "scss", "less"],
    "[javascript]": {
      "editor.defaultFormatter": "dbaeumer.vscode-eslint"
    },
    "[typescript]": {
      "editor.defaultFormatter": "dbaeumer.vscode-eslint",
      "singleQuote": true
    },
    "[html]": {
      "editor.defaultFormatter": "vscode.html-language-features"
    },
    "[jsonc]": {
      "editor.defaultFormatter": "esbenp.prettier-vscode"
    },
    "[json]": {
      "editor.defaultFormatter": "esbenp.prettier-vscode"
    },
    "vetur.completion.autoImport": false,
    "vetur.format.defaultFormatter.js": "none",
    "vetur.format.defaultFormatter.ts": "none",
    "vetur.format.defaultFormatter.html": "none",
    "vetur.grammar.customBlocks": {
      "desc": "js"
    },
    "editor.codeActionsOnSave": {
      "source.fixAll.eslint": true,
      "source.fixAll.stylelint": true
    },
    "eslint.alwaysShowStatus": true,
    "eslint.validate": ["javascript", "typescript", "vue"]
  }
  
}
