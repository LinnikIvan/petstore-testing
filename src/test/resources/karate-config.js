function () {

    karate.configure('retry', {count: 30, interval: 1000});

    var config = {
        appUrl: 'http://localhost:8088'
    }

    return config;
}