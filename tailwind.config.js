/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html",
  ],
  theme: {
    extend: {
      colors: {
        brand: '#0056a6',
        accent: '#f5a623',
        dark: '#1a1a1a',
        text: '#333',
        textLight: '#666',
        border: '#e0e0e0',
        bgLight: '#f5f5f5',
        green: '#28a745',
        red: '#cc0000'
      },
      fontSize: {
        '6xl': '3.5rem',
        '4xl': '2.25rem',
        '2xl': '1.5rem',
        'xl': '1.25rem',
        'lg': '1.125rem',
        'sm': '0.875rem',
        'xs': '0.75rem'
      }
    },
  },
  plugins: [],
}