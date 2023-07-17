import axios from 'axios';

const NEWS_API_BASE_URL = "http://localhost:8080/api/news";


class NewsService {

    getNews() {
        return axios.get(NEWS_API_BASE_URL)
            .then(response => response.data);
    }            
    createNews(news) {
        return axios.post(NEWS_API_BASE_URL, news)
            .then(response => response.data);
    }

    getNewsById(id) {
        return axios.get(NEWS_API_BASE_URL + "/" + id)
            .then(response => response.data);
    }
    
    

    updateNews(news) {
        const id = news.id;
        return axios.put(NEWS_API_BASE_URL + "/" + id, news)
            .then(response => response.data);
    }

    deleteNews(id) {
        return axios.delete(NEWS_API_BASE_URL + "/" + id);
    }
}

export default new NewsService();
